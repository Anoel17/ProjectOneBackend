package model;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;


@Entity 
@Table(name = "request_info")
public class RequestDB {

	public class FileDB {
		
		@Id
		@GeneratedValue(generator = "request_id")
		private int requestId;
		
		private int userId;
		
		private String date;
		
		private int amount;
		
		private String status;
		
		private String expenseType;
		
		@Lob
		private byte[] imageUrl;
		
		public FileDB() {	
	}

		public FileDB(int requestId, int userId, String date, int amount, String status, String expenseType, byte[] imageUrl) {
			this.requestId = requestId;
			this.userId = userId;
			this.date = date;
			this.amount = amount;
			this.status = status;
			this.expenseType = expenseType; 
			this.imageUrl = imageUrl;			
		}

		public int getRequestId() {
			return requestId;
		}

		public void setRequestId(int requestId) {
			this.requestId = requestId;
		}

		public int getUserId() {
			return userId;
		}

		public void setUserId(int userId) {
			this.userId = userId;
		}

		public String getDate() {
			return date;
		}

		public void setDate(String date) {
			this.date = date;
		}

		public int getAmount() {
			return amount;
		}

		public void setAmount(int amount) {
			this.amount = amount;
		}

		public String getStatus() {
			return status;
		}

		public void setStatus(String status) {
			this.status = status;
		}

		public String getExpenseType() {
			return expenseType;
		}

		public void setExpenseType(String expenseType) {
			this.expenseType = expenseType;
		}

		public byte[] getImageUrl() {
			return imageUrl;
		}

		public void setImageUrl(byte[] imageUrl) {
			this.imageUrl = imageUrl;
		}
		
		
	}
		

		
		
}
