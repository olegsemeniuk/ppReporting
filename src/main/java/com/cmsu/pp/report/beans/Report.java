package com.cmsu.pp.report.beans;

import com.pkp.process.beans.IData;

/**
 * Created by Oleg Semeniuk on 12.06.2014.
 */
public class Report implements IData {

    private final int id;
    private String path;
    private String name;
    private String description;

    private String exportFormat;

    public Report(int id, String path, String name, String description, String exportFormat) {
        this.id = id;
        this.path = path;
        this.name = name;
        this.description = description;
        this.exportFormat = exportFormat;
    }

    public int getId() {
        return id;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
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

    public String getExportFormat() {
        return exportFormat;
    }

    public void setExportFormat(String exportFormat) {
        this.exportFormat = exportFormat;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Report report = (Report) o;

        if (id != report.id) return false;
        if (description != null ? !description.equals(report.description) : report.description != null) return false;
        if (!exportFormat.equals(report.exportFormat)) return false;
        if (!name.equals(report.name)) return false;
        if (path != null ? !path.equals(report.path) : report.path != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (path != null ? path.hashCode() : 0);
        result = 31 * result + name.hashCode();
        result = 31 * result + (description != null ? description.hashCode() : 0);
        result = 31 * result + exportFormat.hashCode();
        return result;
    }
}
