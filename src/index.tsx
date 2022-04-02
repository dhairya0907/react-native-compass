import {requireNativeComponent } from 'react-native'
var SharedPreferences = require('react-native-shared-preferences');

export const CompassModule = requireNativeComponent('RNCompassModule');

export function getDegree() {
  return new Promise((resolve, reject) => {
    SharedPreferences.setName("CURRENT_DEGREE");
    SharedPreferences.getItem("degree", function(value : string){
      resolve(value);
    });
  });
}