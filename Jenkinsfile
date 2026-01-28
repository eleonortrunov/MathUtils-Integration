pipeline {
    agent any

    tools {
        maven 'Maven'
    }

    stages {
        stage('Checkout') {
            steps {
                checkout scm
            }
        }

        stage('Build') {
            steps {
                sh 'mvn clean package'
            }
        }

        stage('Test') {
            steps {
                sh 'mvn test'
            }
        }

        stage('SonarQube Analysis') {
            steps {
                withSonarQubeEnv('SonarQube') {
                    sh '''
                      mvn org.sonarsource.scanner.maven:sonar-maven-plugin:sonar \
                        -Dsonar.projectKey=mathutils \
                        -Dsonar.projectName=MathUtils \
                        -Dsonar.host.url=http://localhost:9000
                    '''
                }
            }
        }
    }

    post {
        always {
            junit 'target/surefire-reports/*.xml'

            publishCoverage adapters: [
                jacocoAdapter('target/site/jacoco/jacoco.xml')
            ]

            archiveArtifacts artifacts: 'target/*.jar', fingerprint: true
        }

        success {
            emailext(
                to: '$DEFAULT_RECIPIENTS',
                subject: '$PROJECT_NAME - Build #$BUILD_NUMBER SUCCESS',
                body: 'Build successful. Details: $BUILD_URL'
            )
        }

        failure {
            emailext(
                to: '$DEFAULT_RECIPIENTS',
                subject: '$PROJECT_NAME - Build #$BUILD_NUMBER FAILED',
                body: 'Build failed. Check console output: $BUILD_URL'
            )
        }
    }
}