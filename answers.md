1. There is no getPixels2D method
2. The getPixels2D method is here
3. This does not compile. The interface can be a type, but you can't create an interface object
4. This would compile because DigitalPicture is just the type, and SimplePicture will implement it by creating it
5. This would compile because Picture extends from SimplePicture, which does implement DigitalPicture.
6. This would compile because Picture extends SimplePicture
7. This would not compile because SimplePicture does not extend from Picture