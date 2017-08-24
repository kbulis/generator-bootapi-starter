'use strict';

const Generator = require('yeoman-generator');
const chalk = require('chalk');
const yosay = require('yosay');

module.exports = class extends Generator {
  prompting() {
    this.log(yosay(
      'You are using the ' + chalk.red('bootapi-starter ' + require('../../package.json').version) + ' generator...'
    ));

    const prompts = [
      {type: 'input',
        name: 'name',
        message: 'Your api\'s name and artifact id',
        default: this.appname
      },
      {type: 'input',
        name: 'path',
        message: 'Your api\'s package',
        default: 'com.whatever.code.api'
      },
      {type: 'input',
        name: 'group',
        message: 'Your api\'s group id',
        default: 'com.whatever.code'
      },
      {type: 'input',
        name: 'description',
        message: 'Your project description',
        default: 'Just another generated java api...'
      },
      {type: 'input',
        name: 'author',
        message: 'Author'
      },
      {type: 'input',
        name: 'email',
        message: 'Email'
      },
      {type: 'input',
        name: 'company',
        message: 'Company'
      },
      {type: 'input',
        name: 'repository',
        message: 'Repository'
      }
    ];

    return this.prompt(prompts).then(props => {
      this.props = props;
    });
  }

  writing() {
    this.fs.copyTpl(this.templatePath('_src/main/java/path/**'), this.destinationPath('src/main/java/' + this.props.path.split('.').join('/'))
      , this.props
    );

    this.fs.copyTpl(this.templatePath('_src/test/java/path/**'), this.destinationPath('src/test/java/' + this.props.path.split('.').join('/'))
      , this.props
    );

    this.fs.copyTpl(this.templatePath('_src/main/resources/**'), this.destinationPath('src/main/resources')
      , this.props
    );

    this.fs.copyTpl(this.templatePath('_.classpath'), this.destinationPath('.classpath')
      , this.props
    );

    this.fs.copyTpl(this.templatePath('_.gitignore'), this.destinationPath('.gitignore')
      , this.props
    );

    this.fs.copyTpl(this.templatePath('_.project'), this.destinationPath('.project')
      , this.props
    );

    this.fs.copyTpl(this.templatePath('_.travis.yml'), this.destinationPath('.travis.yml')
      , this.props
    );

    this.fs.copyTpl(this.templatePath('_pom.xml'), this.destinationPath('pom.xml')
      , this.props
    );
  }
};
