pipeline
{
    agent any
    stages
    {
        stage('ContDownload')
        {
            steps
            {
                git 'https://github.com/intelliqittrainings/maven.git'
            }
        }
        stage('ContBuild')
        {
            steps
            {
               sh 'mvn package'
            }
        }
        stage('ContDeployment')
        {
            steps
            {
               deploy adapters: [tomcat9(credentialsId: '00ba1864-f667-4649-b5fb-bbc5955ebc83', path: '', url: 'http://172.31.90.6:8080')], contextPath: 'mytestapp', war: '**/*.war'
            }   
        }
        stage('ContTesting')
        {
            steps
            {
               git 'https://github.com/intelliqittrainings/FunctionalTesting.git'
               sh 'java -jar /var/lib/jenkins/workspace/DeclarativePipeline/testing.jar'
            }
        }
        stage('ContDelivery')
        {
            steps
            {
               deploy adapters: [tomcat9(credentialsId: '00ba1864-f667-4649-b5fb-bbc5955ebc83', path: '', url: 'http://172.31.94.232:8080')], contextPath: 'myprodapp', war: '**/*.war'
            }
        }
    }
}
