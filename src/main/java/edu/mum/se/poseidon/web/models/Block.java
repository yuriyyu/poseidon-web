package edu.mum.se.poseidon.web.models;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;

public class Block {

	private long id;
	@NotEmpty
	private String name;
    private String startDate;
    private String endDate;
    @NotNull
    private EntryModel entryModel;

	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getStartDate() {
		return startDate;
	}
	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}
	public String getEndDate() {
		return endDate;
	}
	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}
	public EntryModel getEntryModel() {
		return entryModel;
	}
	public void setEntryModel(EntryModel entryModel) {
		this.entryModel = entryModel;
	}
}
