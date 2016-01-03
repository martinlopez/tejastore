package tejastore;
import java.util.Date;

public class Venta {

	private long id;

	private Date horario;

	private float monto;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Date getHorario() {
		return horario;
	}

	public void setHorario(Date horario) {
		this.horario = horario;
	}

	public float getMonto() {
		return monto;
	}

	public void setMonto(float monto) {
		this.monto = monto;
	}

	@Override
	public String toString() {
		return "Venta [id=" + id + ", horario=" + horario + ", monto=" + monto
				+ "]";
	}

}