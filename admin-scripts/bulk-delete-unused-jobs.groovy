/**
	Lists and deletes Freestyle and Pipeline jobs that have never been run
    Deletion of jobs can be suppressed by specifying dryRun = true parameter
	
**/

jenkinsService = Jenkins.instance
ArrayList jobList = new ArrayList()

jobList.addAll(jenkinsService.getAllItems(hudson.model.FreeStyleProject))
jobList.addAll(jenkinsService.getAllItems(org.jenkinsci.plugins.workflow.job.WorkflowJob))

def jobNamePattern = ""
def dryRun = "true".toBoolean()
println "Dry Run mode: $dryRun"

jobList.each { job ->
	//println "* $job.fullName" 
  	if (job.firstBuild == null) {
    	println "* $job.fullName - has never been run"
		if (job.fullName.contains(jobNamePattern)) {
  			println "Found job for deletion - $job.fullName"
    		if (!dryRun) {
      			job.delete()
        		println "deleted - $job.fullName"   
    		} else {
    			println "will delete - $job.fullName"
    		}
		}    
	}
}


return