def gitDownload(repo)
{
  git "https://github.com/Saujanya00/${repo}.git" 
def mavenBuild()
{
  sh 'mvn package'
}
def tomcatDeploy(ip,context)
{
  deploy adapters: [tomcat9(credentialsId: '00ba1864-f667-4649-b5fb-bbc5955ebc83', path: '', url: '${ip}')], contextPath: '${context}', war: '**/*.war'
}
