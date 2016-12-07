package com.zhou.service;

import java.util.List;

import com.zhou.model.Position;

public interface PositionService {
	public void savePos(Position position);
    public List<Position> findAllPos();
    public void updatePos(Position position);
}
