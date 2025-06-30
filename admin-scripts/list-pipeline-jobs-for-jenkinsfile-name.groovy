println "List of pipeline jobs that use a specified Jenkinsfile : "
println("==========================================================")

count = 0
def details = false
def jobLocationPattern = "DEV-Builds"
def search = 'contains'
def jenkinsFilePattern = 'Jenkinsfile-Dev-Build'
//def jenkinsFilePattern = 'Jenkinsfile-Dev-Trial'

// List all pipeline jobs
Jenkins.instance.getAllItems(org.jenkinsci.plugins.workflow.job.WorkflowJob).each{ job ->
    
	if (job.fullName.contains(jobLocationPattern)) {
    	def match = job.configFile.file.find { it."$search"(jenkinsFilePattern) } != null 
       	if (match || job.name."$search"(jenkinsFilePattern)) {
        	println "<a href=\"${job.absoluteUrl}configure\">${job.name}</a> matches"
          	++count

          	if (details.toBoolean()) {
            	job.configFile.file.findAll { it."$search"(pattern) }.each { println '    ' + it.trim() }
          	}
       }
    }
}
return
