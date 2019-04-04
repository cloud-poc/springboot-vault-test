# springboot-vault-test
Springboot intergrats with HashiCorp Vault

details please refer to https://www.jianshu.com/p/fccccdc42877

found an bug, if you don't put **spring.application.name: vault-test** in bootstrap.yml,  data configured in Vault seems could not be loaded
