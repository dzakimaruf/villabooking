package com.projectvilla.villabooking.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;


@Embeddable
public class LineItemId implements Serializable {

  private static final long serialVersionUID = 1L;

  
  @Column(name = "cart_id")
  private Long cartId;
  @Column(name = "prod_id")
  private Long villaId;

  
  public LineItemId() {
  }

  public LineItemId(Long cartId, Long villaId) {
    this.cartId = cartId;
    this.villaId = villaId;
  }


    @Override
    public int hashCode() {
      final int prime = 31;
      int result = 1;
      result = prime * result + ((cartId == null) ? 0 : cartId.hashCode());
     
      result = prime * result + ((villaId == null) ? 0 : villaId.hashCode());
      return result;
    }

    @Override
    public boolean equals(Object obj) {
      if (this == obj)
        return true;
      if (obj == null)
        return false;
      if (getClass() != obj.getClass())
        return false;
      LineItemId other = (LineItemId) obj;
      if (cartId == null) {
        if (other.cartId != null)
          return false;
      } else if (!cartId.equals(other.cartId))
        return false;
    
      if (villaId == null) {
        if (other.villaId != null)
          return false;
      } else if (!villaId.equals(other.villaId))
        return false;
      return true;
    }

  


}