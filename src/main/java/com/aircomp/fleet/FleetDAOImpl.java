package com.aircomp.fleet;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.aircomp.plane.Plane;

import java.io.*;
import java.util.Objects;

public class FleetDAOImpl implements FleetDAO<Plane>, Serializable{
    private static final Logger LOG = LoggerFactory.getLogger(FleetDAOImpl.class);
    private static final String path = "src/main/resources/fleet/";

    @Override
    public void save(Fleet<Plane> fleet, String fileName) {
        Objects.requireNonNull(fleet, "Fleet is null First create new Fleet");
        try (ObjectOutputStream objOutStr = new ObjectOutputStream(new FileOutputStream(this.getPath() + fileName))) {
            objOutStr.writeObject(fleet);
        } catch (IOException e) {
            LOG.error("Saving file Fleet. Couldn't write file to " + this.getPath() + fileName, e);
        }
    }

    @Override
    @SuppressWarnings("unchecked")
    public Fleet<Plane> load(String fileName) {

        File f = new File(this.getPath() + fileName);

        if (!f.exists() || f.isDirectory()) {
            LOG.error("Loading file Fleet. Couldn't find file " + this.getPath() + fileName);
            throw new IllegalArgumentException(fileName);
        }

        Fleet<Plane> fleet = null;

        try (ObjectInputStream objInStr = new ObjectInputStream(new FileInputStream(this.getPath() + fileName))) {
            fleet = (Fleet<Plane>) objInStr.readObject();
        } catch (IOException e) {
            LOG.error("Loading fleet Couldn't read file " + this.getPath() + fileName, e);
        } catch (ClassNotFoundException e) {
            LOG.error("Couldn't find class during loading Fleet" + Fleet.class, e);
        }

        return fleet;
    }

    public String getPath() {
        return path;
    }
}
