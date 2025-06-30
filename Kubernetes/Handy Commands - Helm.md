
===Validate your helm charts using this! 

```
helm template . > $HOME/Documents/output.txt
kubectl apply --validate=true -f $HOME/Documents/output.txt

This command helps generate final manifest files for TEKTON PIPELINE 
```

| **Step**        | **Command**                     | **Purpose**                           |
| --------------- | ------------------------------- | ------------------------------------- |
| 🛠 Lint         | helm lint mychart/              | Checks syntax and structure           |
| 📄 Render       | helm template mychart/          | Validates YAML output                 |
| 🎭 Dry Run      | helm install --dry-run --debug  | Simulates installation                |
| 🔎 Values       | helm get values myrelease       | Confirms correct values               |
| 🚀 Install      | helm install myrelease mychart/ | Tests real deployment                 |
| 🔄 Upgrade      | helm upgrade myrelease mychart/ | Checks upgrade process                |
| 🧪 Test         | helm test myrelease             | Runs Helm tests                       |
| 🧐 Schema Check | kubeval                         | Verifies Kubernetes resource validity |
