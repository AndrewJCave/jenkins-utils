/**
	Lists all jobs both Freestyle and Pipeline
	Will delete a job that matches a name pattern

	An optional dry run proprty is used to allow the reporting of what will be deleted
**/

jenkinsService = Jenkins.instance
ArrayList jobList = new ArrayList()

jobList.addAll(jenkinsService.getAllItems(hudson.model.FreeStyleProject))
jobList.addAll(jenkinsService.getAllItems(org.jenkinsci.plugins.workflow.job.WorkflowJob))

def jobNamePattern = "gen-86"
def dryRun = "false".toBoolean()
println "Dry Run mode: $dryRun"

jobList.each { job ->
	println "* $job.fullName" 
  	if (job.fullName.contains(jobNamePattern)) {
  		println "Found dev build job - $job.fullName"
    if (!dryRun) {
      	job.delete()
        println "deleted - $job.fullName"   
    } else {
    	println "will delete - $job.fullName"
    }
      
  }
}

return