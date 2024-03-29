package creatures;


import graphics.Renderer;
import graphics.primitives.Quad;
import logic.Database;
import logic.Database.Creature_Data;
import logic.Database.Item_Data;
import logic.Main;
import settings.CompiledSettings;
import utility.Colors;
import utility.vec2;

public class Item extends Creature {

	@Override
	public Creature construct(float x, float y, String id) {
		return commonConstruct(x, y, id);
	}

	@Override
	public void die() {
		//commonDie();
	}

	@Override
	public void draw(Renderer renderer, float preupdate_scale) {
		vec2 pos = new vec2(
				(getPos().x + getVel().x * preupdate_scale / CompiledSettings.UPDATES_PER_SECOND - 0.5f) * CompiledSettings.TILE_SIZE, 
				(getPos().y + getVel().y * preupdate_scale / CompiledSettings.UPDATES_PER_SECOND - 0.5f) * CompiledSettings.TILE_SIZE);
		vec2 size = new vec2(CompiledSettings.TILE_SIZE);
		pos.mul(Main.game.renderScale());
		size.mul(Main.game.renderScale());

		int texture = Database.getItem(id).texture;
		renderer.submit(new Quad(pos, size, texture, Colors.WHITE));
	}

	@Override
	public void update(float ups) {
		commonUpdate(ups);
	}

	@Override
	public void collide(float ups) {
		commonCollide(ups);
	}

	@Override
	public void ai(float ups) {
		//NO AI
	}
	
	@Override
	public Creature_Data getData() {
		return Database.getCreature("item");
	}
	
	public Item_Data getItemData() {
		return Database.getItem(id);
	}

}
