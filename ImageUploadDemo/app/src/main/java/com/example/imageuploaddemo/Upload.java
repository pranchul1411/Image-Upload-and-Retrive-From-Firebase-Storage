package com.example.imageuploaddemo;

public class Upload {
        private String title;
        private String image;

        public Upload() {
        }

        public Upload(String title, String image) {
            if(title.trim().equals("")){
                title = "No Name";
            }
            this.title = title;
            this.image = image;
        }
        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getImage() {
            return image;
        }

        public void setImage(String image) {
            this.image = image;
        }
}


