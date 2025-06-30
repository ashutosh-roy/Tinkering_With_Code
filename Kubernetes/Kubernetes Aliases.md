vi ~/.zshrc
```
# ---- KUBECTL ALIASES ----
alias k='kubectl'
alias kgp='kubectl get pods'
alias kgs='kubectl get svc'
alias kgn='kubectl get nodes'
alias kga='kubectl get all'
alias kaf='kubectl apply -f'
alias kdf='kubectl delete -f'
alias kctx='kubectl config get-contexts'
alias kuc='kubectl config use-context'
alias kcc='kubectl config current-context'
alias ke-'kubectl get events --sort-by=.metadata.creationTimestamp'

```

source ~/.zshrc