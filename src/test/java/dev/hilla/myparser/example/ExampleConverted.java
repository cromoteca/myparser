package dev.hilla.myparser.example;

import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.type.TypeFactory;
import com.fasterxml.jackson.databind.util.Converter;
import dev.hilla.myparser.example.ExampleConverted.ByteArrayToImageUrl;
import dev.hilla.myparser.example.ExampleConverted.ImageUrlToByteArray;

@JsonSerialize(converter = ByteArrayToImageUrl.class)
@JsonDeserialize(converter = ImageUrlToByteArray.class)
public class ExampleConverted {

    private byte[] image = "hello1".getBytes();

    public byte[] getImage() {
        return image;
    }

    public void setImage(byte[] image) {
        this.image = image;
    }

    public static class ImageURL {

        private String imageURL;

        public String getImageURL() {
            return imageURL;
        }

        public void setImageURL(String imageURL) {
            this.imageURL = imageURL;
        }
    }

    public static class ByteArrayToImageUrl implements Converter<ExampleConverted, ImageURL> {

        @Override
        public JavaType getInputType(TypeFactory typeFactory) {
            return typeFactory.constructType(ExampleConverted.class);
        }

        @Override
        public JavaType getOutputType(TypeFactory typeFactory) {
            return typeFactory.constructType(ImageURL.class);
        }

        @Override
        public ImageURL convert(ExampleConverted value) {
            return new ImageURL();
        }

    }

    public static class ImageUrlToByteArray implements Converter<ImageURL, ExampleConverted> {

        @Override
        public JavaType getInputType(TypeFactory typeFactory) {
            return typeFactory.constructType(ImageURL.class);
        }

        @Override
        public JavaType getOutputType(TypeFactory typeFactory) {
            return typeFactory.constructType(ExampleConverted.class);
        }

        @Override
        public ExampleConverted convert(ImageURL value) {
            return new ExampleConverted();
        }

    }

}
