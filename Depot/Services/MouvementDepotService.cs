using Microsoft.EntityFrameworkCore;
using Depot.Data;
using Depot.Models;

namespace Depot.Services
{
    public class MouvementDepotService
    {
        private readonly AppDbContext _context;

        public MouvementDepotService(AppDbContext context)
        {
            _context = context;
        }

        public async Task<List<MouvementDepot>> GetAllMouvementsAsync()
        {
            return await _context.MouvementDepot.ToListAsync();
        }

        public async Task<MouvementDepot> AddMouvementAsync(MouvementDepot mouvement)
        {
            _context.MouvementDepot.Add(mouvement);
            await _context.SaveChangesAsync();
            return mouvement;
        }
    }
}
