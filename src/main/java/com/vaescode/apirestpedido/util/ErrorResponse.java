package com.vaescode.apirestpedido.util;

import java.util.Date;
import java.util.List;

public class ErrorResponse {


		public ErrorResponse(int status, String message, Date timestamp, List<String> errors) {
			super();
			this.status = status;
			this.message = message;
			this.timestamp = timestamp;
			this.errors = errors;
		}

		public ErrorResponse() {
			super();
		}

		private int status;

		private String message;

		private Date timestamp;

		List<String> errors;
		
		

		public int getStatus() {
			return status;
		}

		public void setStatus(int status) {
			this.status = status;
		}

		public String getMessage() {
			return message;
		}

		public void setMessage(String message) {
			this.message = message;
		}

		public Date getTimestamp() {
			return timestamp;
		}

		public void setTimestamp(Date timestamp) {
			this.timestamp = timestamp;
		}

		public List<String> getErrors() {
			return errors;
		}

		public void setErrors(List<String> errors) {
			this.errors = errors;
		}

		ErrorResponse(String message) {
			this.message = message;
		}
}
