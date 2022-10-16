package org.launchcode.codingevents.models;

import javax.validation.constraints.*;
import java.util.Date;
import java.util.Objects;

public class Event {

    private int id;
    private static int nextId = 1;

    @Size(min = 3, max = 50, message = "Name must be between 3 and 50 characters.")
    @NotBlank(message = "Name is required.")
    private String name;

    @Size(max = 500, message = "Description is too long.")
    private String description;

    @NotBlank(message = "Location is required.")
    @NotNull(message = "Location is required.")
    private String location;

    @PastOrPresent()
    private Date date;

    @NotBlank(message = "Email address is required.")
    @Email(message = "You have entered an invalid email address.")
    private String contactEmail;

    @NotNull
    @Pattern(regexp = "^true$|^false$", message = "Input must be true or false.")
    private String isRegistrationRequired;

    @Positive(message="Number of attendees must be one or more.")
    private int numberOfAttendees;

    public Event(String name, String description, String location, Date date, String contactEmail, String isRegistrationRequired, int numberOfAttendees) {
        this.name = name;
        this.description = description;
        this.location = location;
        this.date = date;
        this.contactEmail = contactEmail;
        this.isRegistrationRequired = isRegistrationRequired;
        this.numberOfAttendees = numberOfAttendees;
        this.id = nextId;
        nextId++;
    }

    public Event() {
        this.id = nextId;
        nextId++;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getId() {
        return id;
    }

    public String getContactEmail() {
        return contactEmail;
    }

    public void setContactEmail(String contactEmail) {
        this.contactEmail = contactEmail;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getIsRegistrationRequired() {
        return isRegistrationRequired;
    }

    public void setIsRegistrationRequired(String isRegistrationRequired) {
        this.isRegistrationRequired = isRegistrationRequired;
    }

    public int getNumberOfAttendees() {
        return numberOfAttendees;
    }

    public void setNumberOfAttendees(int numberOfAttendees) {
        this.numberOfAttendees = numberOfAttendees;
    }

    @Override
    public String toString() {
        return "Event ID: " + id + "\nEvent Name: " + name + "\nDescription: " + description;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Event event = (Event) o;
        return id == event.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
