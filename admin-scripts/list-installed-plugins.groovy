/**
This script lists all installed plugins in Jenkins along with their versions.
**/

println("Listing all installed plugins:")
println("=====================================")
Jenkins.instance.pluginManager.plugins
        .collect()
.sort{ it.getShortName() }
.each {
   plugin -> println("${plugin.getShortName()}:${plugin.getVersion()}")
}  
return

