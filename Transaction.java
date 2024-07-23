
    import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
    class Transaction {
        // declaring instances
        private String type;
        private double amount;
        private String date;
        private String time;
        // constructer for transaction
        public Transaction(String type, double amount) {
            this.type = type;
            this.amount = amount;
            this.date = LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd-MM-yyyy"));
            this.time = LocalDateTime.now().format(DateTimeFormatter.ofPattern("HH:mm:ss"));}
        // getters will return
        public String getType() {
            return type;
        }
        public double getAmount() {
            return amount;
        }
        public String getDate() {
            return date;
        }
        public String getTime() {
            return time;
        }
    }
