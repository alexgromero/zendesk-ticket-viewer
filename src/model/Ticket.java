package model;

public class Ticket {
	/*
	 * This class creates the Ticket object and corresponding attributes
	 */
	private long id;
	private String subject;
	private String description;
	private long requester_id;
	private String created_at;
	private String updated_at;
	private String status;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Long getRequesterId() {
		return requester_id;
	}

	public void setRequesterId(Long requester_id) {
		this.requester_id = requester_id;
	}

	public String getCreatedAt() {
		return created_at;
	}

	public void setCreatedAt(String created_at) {
		this.created_at = created_at;
	}

	public String getUpdatedAt() {
		return updated_at;
	}

	public void setUpdatedAt(String updated_at) {
		this.updated_at = updated_at;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
}
