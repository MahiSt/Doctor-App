package com.machoapp.util;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.machoapp.model.*;

public interface IRowMapper {

	List<Dress> rowMap(ResultSet resultset) throws SQLException;
}
