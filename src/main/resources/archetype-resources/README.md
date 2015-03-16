#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )

${symbol_pound}${symbol_pound}${symbol_pound}${symbol_pound}${symbol_pound}${symbol_pound}  Descrição do Repositorio  ${symbol_pound}${symbol_pound}${symbol_pound}${symbol_pound}${symbol_pound}${symbol_pound}

Estrutura de um projeto Web com Spring Framework

${symbol_pound}${symbol_pound}${symbol_pound}${symbol_pound}${symbol_pound}${symbol_pound}  Estrutura do projeto  ${symbol_pound}${symbol_pound}${symbol_pound}${symbol_pound}${symbol_pound}${symbol_pound}
```
[ROOT]
|\
| +---[doc]
| |\
| | \
| |  +---[BD]  - Scripts SQL para Iniciar o Banco de Dados
| |  |
| |  +---[UML] - Diagramas UML, SaveFile do Programa para monta-los
| |
| |
| +---[src] - Arquivos Fonte Java
| |
| |
| +---[yo]
| |\
| | \
| |  +--- [app]
| |  |
| |  |---bower.json   - Dependencias de Bibliotecas importadas pelo bower
| |  |
| |  |---Gruntfile.js - Configurações das tarefas do Grunt 
| |  |
| |  |---package.json - Dependencia de Modulos.
| |
| |
| |---pom.xml - Configurações do maven, dependencias do Java
```

${symbol_pound}${symbol_pound}${symbol_pound}${symbol_pound}${symbol_pound}${symbol_pound}  Bibliotecas e Softwares necessários  ${symbol_pound}${symbol_pound}${symbol_pound}${symbol_pound}${symbol_pound}${symbol_pound}
* Maven
* NodeJS
* Npm
* Yeoman
* Bower
* Grunt
* generator-angular
* RVM - Stable Ruby
* Sass
* compass
* Git


${symbol_pound}${symbol_pound}${symbol_pound}${symbol_pound}${symbol_pound}${symbol_pound}  Instalando NodeJS e NPM  ${symbol_pound}${symbol_pound}${symbol_pound}${symbol_pound}${symbol_pound}${symbol_pound}
```bash
sudo apt-get -y install curl
curl -sL https://deb.nodesource.com/setup | sudo bash -
sudo apt-get -y install nodejs
```
${symbol_pound}${symbol_pound}${symbol_pound}${symbol_pound}${symbol_pound}${symbol_pound}  Checar as versões  ${symbol_pound}${symbol_pound}${symbol_pound}${symbol_pound}${symbol_pound}${symbol_pound}
```bash
node --version && npm --version
```
${symbol_pound}${symbol_pound}${symbol_pound}${symbol_pound}${symbol_pound}${symbol_pound}  Instalando Yeoman, Bower, Grunt, Generator-Angular  ${symbol_pound}${symbol_pound}${symbol_pound}${symbol_pound}${symbol_pound}${symbol_pound}
```bash
sudo npm install -g yo bower grunt-cli
sudo npm install -g generator-angular
```
${symbol_pound}${symbol_pound}${symbol_pound}${symbol_pound}${symbol_pound}${symbol_pound}  Checar as versões  ${symbol_pound}${symbol_pound}${symbol_pound}${symbol_pound}${symbol_pound}${symbol_pound}
```bash
yo --version && bower --version && grunt --version
```
${symbol_pound}${symbol_pound}${symbol_pound}${symbol_pound}${symbol_pound}${symbol_pound}  RVM e Ruby  ${symbol_pound}${symbol_pound}${symbol_pound}${symbol_pound}${symbol_pound}${symbol_pound}
Acessar o site:
http://rvm.io/rvm/install

```bash
gpg --keyserver hkp://keys.gnupg.net --recv-keys D39DC0E3
\curl -sSL https://get.rvm.io | bash -s stable --ruby
```
${symbol_pound}${symbol_pound}${symbol_pound}${symbol_pound}${symbol_pound}${symbol_pound}  Subir a instancia, pode por .bashrc   ${symbol_pound}${symbol_pound}${symbol_pound}${symbol_pound}${symbol_pound}${symbol_pound}
```bash
source /home/alvaro/.rvm/scripts/rvm
```
${symbol_pound}${symbol_pound}${symbol_pound}${symbol_pound}${symbol_pound}${symbol_pound}  Instalar suporte no grunt serve ao compass sass  ${symbol_pound}${symbol_pound}${symbol_pound}${symbol_pound}${symbol_pound}${symbol_pound}
```bash
gem install compass
```
${symbol_pound}${symbol_pound}${symbol_pound}${symbol_pound}${symbol_pound}${symbol_pound}  Verificar permissão das pastas com os modulos do node  ${symbol_pound}${symbol_pound}${symbol_pound}${symbol_pound}${symbol_pound}${symbol_pound}

${symbol_pound}${symbol_pound}${symbol_pound}${symbol_pound}${symbol_pound}${symbol_pound}  Normalmente em um dos diretorios abaixo:  ${symbol_pound}${symbol_pound}${symbol_pound}${symbol_pound}${symbol_pound}${symbol_pound}
* sudo chown  -R  {user|root}:{user|grupo}  /usr/lib/node_modules
* sudo chown  -R  {user|root}:{user|grupo}  /usr/local/lib/node_modules

${symbol_pound}${symbol_pound}${symbol_pound}${symbol_pound}${symbol_pound}${symbol_pound}  Normalmente em um dos diretorios abaixo:  ${symbol_pound}${symbol_pound}${symbol_pound}${symbol_pound}${symbol_pound}${symbol_pound}
* sudo chmod -R 775	/usr/lib/node_modules
* sudo chmod -R 775	/usr/local/lib/node_modules

${symbol_pound}${symbol_pound}${symbol_pound}${symbol_pound}${symbol_pound}${symbol_pound} Exemplo - Adicionar dependencia bower ${symbol_pound}${symbol_pound}${symbol_pound}${symbol_pound}${symbol_pound}${symbol_pound}
```bash
${symbol_pound}${symbol_pound}${symbol_pound}${symbol_pound}${symbol_pound}${symbol_pound} Adicionar ao projeto ${symbol_pound}${symbol_pound}${symbol_pound}${symbol_pound}${symbol_pound}${symbol_pound}
bower install font-awesome --save

${symbol_pound}${symbol_pound}${symbol_pound}${symbol_pound}${symbol_pound}${symbol_pound} Adicionar apenas para dev ${symbol_pound}${symbol_pound}${symbol_pound}${symbol_pound}${symbol_pound}${symbol_pound}
bower install font-awesome --save-dev
```

${symbol_pound}${symbol_pound}${symbol_pound}${symbol_pound}${symbol_pound}${symbol_pound} Para rodar o projeto depois de clonar o repositorio, deve executar os comandos ${symbol_pound}${symbol_pound}${symbol_pound}${symbol_pound}${symbol_pound}${symbol_pound}
```bash
cd ~/IdeaProjects/${artifactId}/yo

${symbol_pound}${symbol_pound}${symbol_pound}${symbol_pound}${symbol_pound}${symbol_pound} Modulos do projecto yo,grunt,npm,bower,etc ${symbol_pound}${symbol_pound}${symbol_pound}${symbol_pound}${symbol_pound}${symbol_pound}
npm update

${symbol_pound}${symbol_pound}${symbol_pound}${symbol_pound}${symbol_pound}${symbol_pound} Depencias do bibliotecas ${symbol_pound}${symbol_pound}${symbol_pound}${symbol_pound}${symbol_pound}${symbol_pound}
bower install

${symbol_pound}${symbol_pound}${symbol_pound}${symbol_pound}${symbol_pound}${symbol_pound} Compilar o projeto e gerar o front-end para a aplicação ${symbol_pound}${symbol_pound}${symbol_pound}${symbol_pound}${symbol_pound}${symbol_pound}
grunt
```