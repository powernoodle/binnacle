# Binnacle

Binnacle contains all of your assets within a hash-map in an effort to make all assets immediately available and minimize requests to the server.

Texture atlases are nice and also solve this problem, but are problematic in finding the optimal packing algorithm and make manipulating a specific image in the pack especially difficult. Encoding assets as data we pay a small price in increased payload to the client for the trade-off of being able to manipulate SVGs within the client without the need to store multiple colour variants of the same image.

![binnacle](http://clojars.org/com.powernoodle/binnacle/latest-version.svg)

## Usage

Place all of your assets that you want to package into a map in a directory somewhere accessible in your project (ex. "resources/assets").

Currently supported file types:

- png
- jpg
- gif
- woff

```Clojure
(:require [binnacle.core :as binnacle])

(def assets
    (binnacle/assets "resources/assets/"))
;; {:resources {:assets {:logo.png "BASE64_ENCODED_DATA..."}

(binnacle/data-url assets [:resources :assets :logo.png])
;; "data:image/png;base64,BASE64_ENCODED_DATA..."
```

## Future Enhancements

Supported file types are unfortunately hard-coded currently as I haven't been able to uncover a reliable method for returning the correct mime type for a file. Once this is possible binnacle will be able to handle any file you may wish to encode as data.

## License

Copyright © 2015 [Powernoodle](http://powernoodle.com)

Distributed under the Eclipse Public License either version 1.0 or (at
your option) any later version.
