package Helpers;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;


public class MyResponse {

        @JsonProperty("id")
        public int id;

        @JsonProperty("title")
        private String title;

        @JsonProperty("verified")
        private boolean verified;

        @JsonProperty("addition")
        private Addition addition;

        @JsonProperty("important_numbers")
        private List<Integer> importantNumbers;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public boolean isVerified() {
            return verified;
        }

        public void setVerified(boolean verified) {
            this.verified = verified;
        }

        public Addition getAddition() {
            return addition;
        }

        public void setAddition(Addition addition) {
            this.addition = addition;
        }

          public List<Integer> getImportantNumbers() {
             return importantNumbers;
          }

         public void setImportantNumbers(List<Integer> importantNumbers) {
               this.importantNumbers = importantNumbers;
         }


        public static class Addition {

            @JsonProperty("additional_info")
            private String additionalInfo;

            @JsonProperty("additional_number")
            private int additionalNumber;

            @JsonProperty("id")
            private int id;

            public String getAdditionalInfo() {
                return additionalInfo;
            }

            public void setAdditionalInfo(String additionalInfo) {
                this.additionalInfo = additionalInfo;
            }

            public int getAdditionalNumber() {
                return additionalNumber;
            }

            public void setAdditionalNumber(int additionalNumber) {
                this.additionalNumber = additionalNumber;
            }
        }
}
