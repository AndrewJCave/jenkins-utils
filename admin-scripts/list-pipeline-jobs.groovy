/**
This script lists all pipeline jobs with full name / location.
**/

println "List of pipeline jobs : "
println("=====================================")
// List all pipeline jobs
  Jenkins.instance.getAllItems(org.jenkinsci.plugins.workflow.job.WorkflowJob).each{ job ->
      println "* $job.fullName"      
  }
  return