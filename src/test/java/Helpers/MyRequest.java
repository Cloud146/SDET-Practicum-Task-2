package Helpers;

public class MyRequest {
        private String title;
        private boolean verified;
        private Addition addition;
        private int[] important_numbers;

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

        public int[] getImportant_numbers() {
            return important_numbers;
        }

        public void setImportant_numbers(int[] important_numbers) {
            this.important_numbers = important_numbers;
        }

        public static class Addition {
            private String additional_info;
            private int additional_number;

            public String getAdditional_info() {
                return additional_info;
            }

            public void setAdditional_info(String additional_info) {
                this.additional_info = additional_info;
            }

            public int getAdditional_number() {
                return additional_number;
            }

            public void setAdditional_number(int additional_number) {
                this.additional_number = additional_number;
            }
        }
}
