var merge = require('webpack-merge');

var generatedConfig = require('./scalajs.webpack.config');
var commonConfig = require('./webpack.config');

module.exports = merge(generatedConfig, commonConfig);