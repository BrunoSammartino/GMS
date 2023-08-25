import java.io.*;

class GymMember implements Serializable {
    private static final long serialVersionUID = 1L;

    private String name;
    private String admissionDate;
    private String contactDetails;
    private boolean feePaid;
    private boolean hasMembership;

    private boolean hasAccessDumbbells;
    private boolean hasAccessBench;
    private boolean hasAccessTreadmill;
    private boolean hasAccessCycle;
    private boolean hasAccessBarbell;

    public GymMember(String name, String admissionDate, String contactDetails) {
        this.name = name;
        this.admissionDate = admissionDate;
        this.contactDetails = contactDetails;
        this.feePaid = false;
        this.hasMembership = false;
        this.hasAccessDumbbells = false;
        this.hasAccessBench = false;
        this.hasAccessTreadmill = false;
        this.hasAccessCycle = false;
        this.hasAccessBarbell = false;
        }

    
    public boolean isHasMembership() {
		return hasMembership;
	}


	public boolean isHasAccessDumbbells() {
		return hasAccessDumbbells;
	}



	public void setHasAccessDumbbells(boolean hasAccessDumbbells) {
		this.hasAccessDumbbells = hasAccessDumbbells;
	}



	public boolean isHasAccessBench() {
		return hasAccessBench;
	}



	public void setHasAccessBench(boolean hasAccessBench) {
		this.hasAccessBench = hasAccessBench;
	}



	public boolean isHasAccessTreadmill() {
		return hasAccessTreadmill;
	}



	public void setHasAccessTreadmill(boolean hasAccessTreadmill) {
		this.hasAccessTreadmill = hasAccessTreadmill;
	}



	public boolean isHasAccessCycle() {
		return hasAccessCycle;
	}



	public void setHasAccessCycle(boolean hasAccessCycle) {
		this.hasAccessCycle = hasAccessCycle;
	}



	public boolean isHasAccessBarbell() {
		return hasAccessBarbell;
	}



	public void setHasAccessBarbell(boolean hasAccessBarbell) {
		this.hasAccessBarbell = hasAccessBarbell;
	}



	public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAdmissionDate() {
        return admissionDate;
    }

    public void setAdmissionDate(String admissionDate) {
        this.admissionDate = admissionDate;
    }

    public String getContactDetails() {
        return contactDetails;
    }

    public void setContactDetails(String contactDetails) {
        this.contactDetails = contactDetails;
    }

    public boolean isFeePaid() {
        return feePaid;
    }

    public void setFeePaid(boolean feePaid) {
        this.feePaid = feePaid;
    }

    public boolean hasMembership() {
        return hasMembership;
    }

    public void setHasMembership(boolean hasMembership) {
        this.hasMembership = hasMembership;
    }
}