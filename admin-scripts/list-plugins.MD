## List installed plugins
```
Jenkins.instance.pluginManager.plugins
        .collect()
.sort{ it.getShortName() }
.each {
   plugin -> println("${plugin.getShortName()}:${plugin.getVersion()}")
}  
return
```

