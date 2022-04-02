# `@dhairyasharma/react-native-compass`

![Supports Android](https://img.shields.io/badge/platforms-android%20-lightgrey.svg) [ ![MIT License](https://img.shields.io/npm/l/@react-native-community/netinfo.svg) ](/LICENSE) ![Maintenance](https://img.shields.io/badge/Maintained%3F-yes-green.svg) [ ![Maintainer](https://img.shields.io/badge/maintainer-dhairya0907-blue) ](https://github.com/dhairya0907) [![Generic badge](https://img.shields.io/badge/version-1.0.0-blue.svg)](https://github.com/dhairya0907/react-native-encryption/releases)

[![Twitter](https://img.shields.io/badge/dhairya__0907-%231DA1F2.svg?style=for-the-badge&logo=Twitter&logoColor=white) ](https://twitter.com/dhairya_0907) [ ![LinkedIn](https://img.shields.io/badge/linkedin-%230077B5.svg?style=for-the-badge&logo=linkedin&logoColor=white) ](https://www.linkedin.com/in/dhairyasharma0907/)

### Native android compass library for react-native
***Only supports Android, for IOS work is in progress.***


&nbsp;

# Getting started

Install the library using either Yarn:

```
yarn add @dhairyasharma/react-native-compaass
yarn add react-native-shared-preferences@1.0.2
```

or npm:

```sh
npm install --save @dhairyasharma/react-native-compass
npm install --save eact-native-shared-preferences@1.0.2
```

or git:

```sh
npm install git+https://github.com/dhairya0907/react-native-compass.git
npm install git+https://github.com/sriraman/react-native-shared-preferences.git
```

### Using React Native >= 0.60

&nbsp;
Linking the package manually is not required anymore with [Autolinking](https://github.com/react-native-community/cli/blob/master/docs/autolinking.md).

&nbsp;

# Usage

## Import the library

```javascript
import { CompassModule, getDegree } from "@dhairyasharma/react-native-compass";
```

## Get compass
```javascript
<CompassModule style={{height : "100%", width : "100%"}} handHeight={270} />

// Here handHeight is the height of the hand in dp
// And the style is the style of the compass
```

## Get the compass Degree
```javascript
getDegree().then(degree => {
  console.log(degree);
});
```

---

**NOTE**

**For detail usage see [example](https://github.com/dhairya0907/react-nativee-compass/blob/a593e7376c48a755a506f972949fe69c48f9aeba/example/src/App.tsx#L1).**

---

&nbsp;

# Acknowledgements
- Module template by [react-native-module-template](https://github.com/demchenkoalex/react-native-module-template)

&nbsp;

# Author

Dhairya Sharma | [@dhairya0907](https://github.com/dhairya0907)

&nbsp;

# License

The library is released under the MIT license. For more information see [`LICENSE`](/LICENSE).
