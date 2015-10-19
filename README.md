# Binnacle

Binnacle contains all of your image assets within a hash-map. Images as data that can be manipulated and used in your website to keep asset requests to a minimum and data always immediately accessible. Rather than keeping different versions of your images with various colour options or rotation/flip transformations, now keep a single reference image that you can manipulate the way you manipulate the rest of your data within your app.

![binnacle](http://clojars.org/com.powernoodle/binnacle/latest-version.svg)

## Usage

Place all of your images within `resources/images`.

Access your images hash-map from `binnacle.core/images` in your Clojure(Script) project!

## License

Copyright © 2015 [Powernoodle](http://powernoodle.com)

Distributed under the Eclipse Public License either version 1.0 or (at
your option) any later version.
