var merge = require('webpack-merge');

var generatedConfig = require('./scalajs.webpack.config.js');
var commonConfig = require('./webpack.config.js');

module.exports = merge(generatedConfig, commonConfig);
