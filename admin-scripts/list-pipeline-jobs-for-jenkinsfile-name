println "List of pipeline jobs that use a specified Jenkinsfile : "
println("==========================================================")

count = 0
def details = false
def search = 'contains'
def pattern = 'Jenkinsfile-Dev-Build'
//def pattern = 'Jenkinsfile-Dev-Trial'

// List all pipeline jobs
  Jenkins.instance.getAllItems(org.jenkinsci.plugins.workflow.job.WorkflowJob).each{ job ->
    
    def match = job.configFile.file.find { it."$search"(pattern) } != null 
    if (match || job.name."$search"(pattern)) {
        println "<a href=\"${job.absoluteUrl}configure\">${job.name}</a> matches"
        ++count

        if (details.toBoolean()) {
          job.configFile.file.findAll { it."$search"(pattern) }.each { println '    ' + it.trim() }
        }
      }
  }
  return
