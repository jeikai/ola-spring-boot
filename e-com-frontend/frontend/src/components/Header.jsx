import { Link, useNavigate } from 'react-router-dom';
import { useState } from 'react';

function Header() {
  const [cartCount, setCartCount] = useState(0);
  const navigate = useNavigate();

  const handleLogoClick = () => {
    navigate('/');
  };

  const handleCartClick = () => {
    // TODO: Mở giỏ hàng hoặc trang cart
    console.log('Cart clicked');
  };

  return (
    <header className="bg-white shadow-md border-b border-gray-200">
      <div className="max-w-7xl mx-auto px-4 sm:px-6 lg:px-8">
        <div className="flex justify-between items-center h-16">
          {/* Logo */}
          <div 
            className="flex items-center gap-3 cursor-pointer hover:opacity-80 transition-opacity" 
            onClick={handleLogoClick}
          >
            <svg width="40" height="40" viewBox="0 0 40 40" fill="none">
              <rect width="40" height="40" rx="8" fill="#FF6B6B"/>
              <text x="50%" y="50%" textAnchor="middle" dominantBaseline="middle" fill="white" fontSize="24" fontWeight="bold">
                EC
              </text>
            </svg>
            <span className="text-xl font-bold text-gray-900">E-Commerce</span>
          </div>

          {/* Navigation Menu */}
          <nav className="hidden md:flex items-center gap-8">
            <Link to="/" className="text-gray-700 hover:text-red-500 font-medium transition-colors">Trang chủ</Link>
            <Link to="/" className="text-gray-700 hover:text-red-500 font-medium transition-colors">Sản phẩm</Link>
            <Link to="/" className="text-gray-700 hover:text-red-500 font-medium transition-colors">Về chúng tôi</Link>
            <Link to="/" className="text-gray-700 hover:text-red-500 font-medium transition-colors">Liên hệ</Link>
          </nav>

          {/* Header Actions */}
          <div className="flex items-center gap-4">
            <Link 
              to="/login" 
              className="hidden sm:inline-block px-4 py-2 text-gray-700 border border-gray-300 rounded-md hover:bg-gray-50 transition-colors"
            >
              Đăng nhập
            </Link>
            <button 
              onClick={handleCartClick}
              className="relative p-2 text-gray-700 hover:text-red-500 transition-colors"
              aria-label="Shopping cart"
            >
              <svg width="24" height="24" viewBox="0 0 24 24" fill="none" stroke="currentColor" strokeWidth="2">
                <circle cx="9" cy="21" r="1" />
                <circle cx="20" cy="21" r="1" />
                <path d="M1 1h4l2.68 13.39a2 2 0 0 0 2 1.61h9.72a2 2 0 0 0 2-1.61L23 6H6" />
              </svg>
              {cartCount > 0 && (
                <span className="absolute top-0 right-0 bg-red-500 text-white text-xs font-bold rounded-full w-5 h-5 flex items-center justify-center">
                  {cartCount}
                </span>
              )}
            </button>
          </div>
        </div>
      </div>
    </header>
  );
}

export default Header;
