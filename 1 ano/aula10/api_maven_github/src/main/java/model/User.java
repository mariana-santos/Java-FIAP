package model;

public class User {
	private String username;
	private String name;
	private int followers;
	private int public_repos;
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getQtt_followers() {
		return followers;
	}
	public void setQtt_followers(int qtt_followers) {
		this.followers = qtt_followers;
	}
	public int getQtt_repos() {
		return public_repos;
	}
	public void setQtt_repos(int qtt_repos) {
		this.public_repos = qtt_repos;
	}
}
