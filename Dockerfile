FROM cgag/jre:11.0.17_8 as builder
WORKDIR /application
COPY target/vica-score-calculator.jar application.jar
RUN java -Djarmode=layertools -jar application.jar extract

FROM cgag/jre:17.0.6_10
WORKDIR /application
COPY --from=builder /application/dependencies/ ./
COPY --from=builder /application/spring-boot-loader/ ./
COPY --from=builder /application/snapshot-dependencies/ ./
COPY --from=builder /application/company-dependencies/ ./
COPY --from=builder /application/application/ ./

CMD ["org.springframework.boot.loader.JarLauncher"]
