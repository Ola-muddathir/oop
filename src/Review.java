
    public class Review {
        private String userName;          // Name of the user providing the review
        private String restaurantName;    // Name of the restaurant being reviewed
        private String reviewText;        // Text of the review
        private double rating;            // Numeric rating (e.g., 1 to 5 stars)
        private String date;              // New: Date of the review
        private boolean isVerified;       // New: Indicates if the review is verified
        private int helpfulVotes;         // New: Tracks the number of helpful votes for the review

        // Constructor
        public Review(String userName, String restaurantName, String reviewText, double rating, String date, boolean isVerified) {
            this.userName = userName;
            this.restaurantName = restaurantName;
            this.reviewText = reviewText;
            this.rating = rating;
            this.date = date;
            this.isVerified = isVerified;
            this.helpfulVotes = 0;
        }

        // Getters and Setters
        public String getUserName() {
            return userName;
        }

        public void setUserName(String userName) {
            this.userName = userName;
        }

        public String getRestaurantName() {
            return restaurantName;
        }

        public void setRestaurantName(String restaurantName) {
            this.restaurantName = restaurantName;
        }

        public String getReviewText() {
            return reviewText;
        }

        public void setReviewText(String reviewText) {
            this.reviewText = reviewText;
        }

        public double getRating() {
            return rating;
        }

        public void setRating(double rating) {
            this.rating = rating;
        }

        public String getDate() {
            return date;
        }

        public void setDate(String date) {
            this.date = date;
        }

        public boolean isVerified() {
            return isVerified;
        }

        public void setVerified(boolean verified) {
            isVerified = verified;
        }

        public int getHelpfulVotes() {
            return helpfulVotes;
        }

        public void setHelpfulVotes(int helpfulVotes) {
            this.helpfulVotes = helpfulVotes;
        }

        // New: Mark the review as helpful
        public void markAsHelpful() {
            this.helpfulVotes++;
            System.out.println("Review marked as helpful. Total helpful votes: " + helpfulVotes);
        }

        // New: Verify the review
        public void verifyReview() {
            this.isVerified = true;
            System.out.println("The review has been verified.");
        }

        // Display review details
        public void displayReview() {
            System.out.println("User: " + userName);
            System.out.println("Restaurant: " + restaurantName);
            System.out.println("Review: " + reviewText);
            System.out.println("Rating: " + rating);
            System.out.println("Date: " + date);
            System.out.println("Verified: " + (isVerified ? "Yes" : "No"));
            System.out.println("Helpful Votes: " + helpfulVotes);
        }
    }

