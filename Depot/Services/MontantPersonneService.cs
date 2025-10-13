using Depot.Data;
using Depot.Models;
using Microsoft.EntityFrameworkCore;
using System.Collections.Generic;
using System.Threading.Tasks;

namespace Depot.Services
{
    public class MontantPersonneService
    {
        private readonly AppDbContext _context;

        public MontantPersonneService(AppDbContext context)
        {
            _context = context;
        }

        public async Task<List<MontantPersonne>> GetAllMontantsAsync()
        {
            return await _context.MontantPersonne.ToListAsync();
        }

    }
}
