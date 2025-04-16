/**
This script lists all freestyle jobs with full name / location.
**/

println "List of freestyle jobs : "
println("=====================================")
// List all freestyle jobs
  Jenkins.instance.getAllItems(hudson.model.FreeStyleProject).each{ job ->
      println "* $job.fullName"      
  }
  return