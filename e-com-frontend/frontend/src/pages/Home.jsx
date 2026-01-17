import { useEffect } from 'react';
import Header from '../components/Header';
import axios from 'axios';
import { API_ENDPOINTS, API_BASE_URL } from "../utils/constants";

function Home() {

  useEffect(() => {
    async function fetchData() {
      try {
        const response = await axios.get(`${API_BASE_URL}${API_ENDPOINTS.PRODUCTS.BASE}`);
        console.log(response.data);
      } catch (error) {
        console.error("Error fetching data", error);
      }
    }

    fetchData();
  }, [])

  return (
    <div className="min-h-screen bg-white">
      <Header />
      
      <main>
        <section className="bg-gradient-to-r from-red-500 to-red-600 text-white py-20 px-4">
          <div className="max-w-7xl mx-auto text-center">
            <h1 className="text-5xl md:text-6xl font-bold mb-4">Chào mừng đến với cửa hàng của chúng tôi</h1>
            <p className="text-xl md:text-2xl text-red-100 mb-8">Khám phá những sản phẩm chất lượng tốt nhất</p>
            <button className="bg-white text-red-600 font-bold py-3 px-8 rounded-lg hover:bg-gray-50 transition duration-200">
              Mua sắm ngay
            </button>
          </div>
        </section>

        {/* Featured Products Section */}
        <section className="py-16 px-4">
          <div className="max-w-7xl mx-auto">
            <h2 className="text-4xl font-bold text-gray-900 mb-12 text-center">Sản phẩm nổi bật</h2>
            <div className="grid grid-cols-1 md:grid-cols-2 lg:grid-cols-4 gap-6">
              {/* Product Card Template */}
              {[1, 2, 3, 4, 5, 6].map((item) => (
                <div key={item} className="bg-white border border-gray-200 rounded-lg shadow hover:shadow-lg transition-shadow p-6">
                  <div className="bg-gray-200 h-48 rounded-lg mb-4 flex items-center justify-center overflow-hidden">
                    <img 
                      src={`https://via.placeholder.com/200?text=Product+${item}`} 
                      alt={`Product ${item}`}
                      className="w-full h-full object-cover"
                    />
                  </div>
                  <h3 className="text-lg font-semibold text-gray-900 mb-2">Sản phẩm {item}</h3>
                  <p className="text-gray-600 text-sm mb-4">Mô tả sản phẩm ngắn gọn</p>
                  <div className="flex justify-between items-center">
                    <span className="text-2xl font-bold text-red-500">99.000đ</span>
                    <button className="bg-red-500 hover:bg-red-600 text-white font-medium py-2 px-4 rounded transition duration-200">
                      Thêm vào giỏ
                    </button>
                  </div>
                </div>
              ))}
            </div>
          </div>
        </section>

        {/* About Section */}
        <section className="bg-gray-50 py-16 px-4">
          <div className="max-w-7xl mx-auto">
            <h2 className="text-4xl font-bold text-gray-900 mb-8 text-center">Về chúng tôi</h2>
            <p className="text-lg text-gray-700 text-center max-w-3xl mx-auto">
              Chúng tôi cam kết cung cấp những sản phẩm chất lượng cao nhất với giá cả hợp lý. 
              Với đội ngũ chuyên nghiệp, chúng tôi luôn sẵn sàng phục vụ quý khách hàng một cách tốt nhất.
            </p>
          </div>
        </section>
      </main>
    </div>
  );
}

export default Home;
