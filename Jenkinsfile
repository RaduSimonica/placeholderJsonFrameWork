#!/usr/bin/env groovy
pipeline {
    agent any

    parameters {
        choice(
            name: "environment",
            choices: [
                "main",
                "secondary"
            ],
            description: "On what environment should the tests run."
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
            description: 'Choose a suite of tests'
        )
        string(
            name: "branch",
            defaultValue: "main",
            description: "The branch from where you want to run tests. Default is main"
        )
    }

    stages {
        stage("Clone repository") {
            steps {
                sh "git clone --branch $branch https://github.com/RaduSimonica/placeholderJsonFrameWork.git ."
            }
        }

        stage("Build image") {
            steps {
                sh "docker build -t tests ."
            }
        }

        stage("Run tests") {
            steps {
                sh 'docker run -v $(pwd)/:/tests tests mvn test -DSuite=$suite -Denvironment=$environment'
            }
        }
    }

    post {
        always {
            testNG()
            cleanWs()
        }
    }
}