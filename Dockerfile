# 1. Base image 선택 (JDK 22)
FROM openjdk:22-jdk

# 2. 작업 디렉토리 생성
WORKDIR /app

# 3. 빌드된 JAR 파일을 복사
COPY build/libs/*.jar app.jar

# 4. 애플리케이션 실행 명령어
ENTRYPOINT ["java", "-jar", "/app/app.jar"]
