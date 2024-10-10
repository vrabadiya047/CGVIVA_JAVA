package com.cargarantie.leanix.service;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import lombok.RequiredArgsConstructor;
import net.leanix.api.GraphqlApi;
import net.leanix.api.common.ApiClient;
import net.leanix.api.common.ApiException;
import net.leanix.api.models.GraphQLRequest;
import net.leanix.api.models.GraphQLResult;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class LeanixGraphQlService {

    private final ApiClient apiClient;

    public GraphQLResult getGraphQlResult(String query) throws ApiException {

        GraphQLRequest graphqlRequest = new GraphQLRequest();
        graphqlRequest.setQuery(query);

        return new GraphqlApi(apiClient).processGraphQL(graphqlRequest);
    }

    public Set<String> searchFactSheets(String searchString) throws ApiException {
        String query = "{" + "allFactSheets(filter: {fullTextSearch: \"" + searchString + "\"}) {"
                + "edges { node {id displayName}}" + "}" + "}";
        GraphQLResult result = getGraphQlResult(query);

        List<Map<String, Object>> edgeList =
                (List<Map<String, Object>>) ((Map<String, Map<String, Object>>) result.getData())
                        .get("allFactSheets").get("edges");

        return edgeList.stream()
                .map(e -> ((Map<String, Object>) e.get("node")).get("displayName").toString())
                .collect(Collectors.toSet());
    }
}
