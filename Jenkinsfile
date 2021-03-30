pipeline {
    agent any
    stages {
        stage('Build') {
            steps {
                sh ''
                    echo "mvn clean package"
                    mvn clean package
                '''
            }
        }
	stage('Unpack jar') {
            steps {
                sh ''
                    echo "unpack jar"
                    cd /target
		    mkdir dependency
		    cd /dependency
		    jar -xf ../firstname-0.0.1-SNAPSHOT.jar
		    cd ../..
                '''
            }
        }
	stage('Build image') {
            steps {
                sh ''
                    echo "unpack jar"
		    docker -t tercoz/firstname .
                '''
            }
        }
	stage('Run') {
            steps {
                sh ''
                    echo "run application"
		    docker run --rm -dp 9081:8080 --net name --name my.firstname.host tercoz/firstname
                '''
            }
        }
    }
}