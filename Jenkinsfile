#!/usr/bin/env groovy
pipeline {
    agent {
        label : 'main'
    }

    parameters {
        choice(
            name: "environment",
            choices: [
                "main",
                "secondary"
            ]
        )
        choice(
            name: "suite",
            choices: [
                "comments_suite.xml",
                "main_suite.xml",
                "photos_suite.xml",
                "posts_suite.xml",
                "users_suite.xml"
            ],
            description: 'Pick something'
        )
    }

    stages {
        stage("Cleanup") {
            steps {
                cleanWs()
            }
        }

        stage("Clone repository") {
            checkout scmGit(
                branches: [[name: 'main']],
                userRemoteConfigs: [[
                    credentialsId: 'github-ssh',
                    url: 'git@github.com:RaduSimonica/placeholderJsonFrameWork.git'
                ]]
            )
        }

        stage("Build and start test image") {
            steps {
                sh "docker build -t tests ."
            }
        }

        stage("Run tests") {
            steps {
                sh "docker run tests mvn test -DSuite=\"${suite}\""
            }
        }
    }

    post {
        always {
            cleanWs()
        }
    }
}